MyArray myArray = new MyArray();
IsPrime isPrime = new IsPrime();

int sum = 0;
for(int num : myArray.createArray(20)){
    if(isPrime.checkPrime(num)){
        sum += num;
    }
}

System.out.println(sum);