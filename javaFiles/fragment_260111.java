int counter = 0;
for (int i = 0; i < array.length; i++) {
    System.out.println("Enter up to ten integers, entering a zero will stop allowing further inputs. ");
    int next = scan.nextInt();
    if (next == 0){
        break;
    }
    counter++;
    array[i] = next; 
}

// So after that, you can use it as divider
double average = counter == 0 ? 0 : sum/counter;