int temp = maxProd;
left = right;
while (temp != 1) {
   temp = temp / list[left--];
}
left++;
// copy array
return Arrays.copyOfRange(list, left, right + 1);