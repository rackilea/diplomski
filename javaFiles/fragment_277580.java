// Heap implementation, since JavaScript has no native one (yet)
const MinHeap = {siftDown(arr, i=0, value=arr[i]) {if (i >= arr.length) return;let key = value[0];while (true) {let j = i*2+1;if (j+1 < arr.length && arr[j][0] > arr[j+1][0]) j++;if (j >= arr.length || key <= arr[j][0]) break;arr[i] = arr[j];i = j;}arr[i] = value;},heapify(arr) {for (let i = arr.length>>1; i--; ) this.siftDown(arr, i);return arr;},pop(arr) {return this.exchange(arr, arr.pop());},exchange(arr, value) {if (!arr.length) return value;let oldValue = arr[0];this.siftDown(arr, 0, value);return oldValue;},push(arr, value) {let key = value[0];let i = arr.length;let j;while ((j = (i-1)>>1) >= 0 && key < arr[j][0]) {arr[i] = arr[j];i = j;}arr[i] = value;return arr;}};

function countAbc(charGroups) {  
    let curr = [];
    let offset = Array(charGroups).fill(0);
    let list = [];
    let width = 0;
    for (let y = 0; y < charGroups.length; y++) {
        let row = charGroups[y];
        let [ch, x] = row.shift(); // This shift must be O(1), which is not guaranteed in JS
        curr.push(ch);
        list.push([x, y]);
        for (let i = 0; i < row.length; i++) {
            let group = row[i];
            x += group[1];
            group[1] = x;
        }
        width = Math.max(width, x);
    }
    
    let heap = MinHeap.heapify(list);
    let count = 0;
    while (heap.length) {
        let [xEnd, y] = MinHeap.pop(heap);
        let row = charGroups[y];
        // Again: shift must be O(1), which is not guaranteed in JS
        let [ch, x] = row.length ? row.shift() : [' ', width+1];
        if (x <= width) MinHeap.push(heap, [x, y]);
        let y0 = Math.max(0, y-2);
        let i = curr.slice(y0, y+3).join("").indexOf("abc");
        if (i >= 0) {
            let prevX = Math.max(...offset.slice(y0+i, y0+i+3));
            count += xEnd - prevX;
        }
        curr[y] = ch;
        offset[y] = xEnd;
    }
    return count;
}

// Example runs:
let input, result;

console.log(countAbc([
    [['a', 8], ['b', 8], ['c', 7]],
    [['a', 3], ['b', 16], ['c', 4]],
    [['c', 6], ['b', 4], ['a', 5], ['b', 5]]
]));
console.log(countAbc([
    [['a', 900000], ['b', 100000]],
    [['a', 750000], ['b', 250000]],
    [['a', 250000], ['c', 750000]], 
]));