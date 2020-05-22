function applyMixins(derivedCtor: any, baseCtors: any[]) {
    baseCtors.forEach(baseCtor => {
        Object.getOwnPropertyNames(baseCtor.prototype).forEach(name => {
             if (name !== 'constructor') {
                derivedCtor.prototype[name] = baseCtor.prototype[name];
            }
        });
    }); 
}

type ComparatorFunc<T> = (o1: T, o2: T) => any;

abstract class Comparator<T> {

    public static lambda<T>(func: ComparatorFunc<T>): Comparator<T> {
        return new class extends Comparator<T> {
            public compare(o1: T, o2: T): number {
                return func(o1, o2);
            }
        }
    }

    public abstract compare(o1: T, o2: T): number;
}

//VAR 1 - lambda
let lambdaComparator: Comparator<number> = Comparator.lambda((n1: number, n2: number) => { return n1 - n2;});
console.log("Lambda comparator");
console.log(lambdaComparator.compare(100, 50));

//VAR 2 - full implementation
class MyComparator implements Comparator<number> {

    public compare(o1: number, o2: number): number {
        return o1 - o2;
    }
}
applyMixins (MyComparator, [Comparator]);

let classComparator: MyComparator = new MyComparator();
console.log("Class comparator");
console.log(classComparator.compare(100, 50));