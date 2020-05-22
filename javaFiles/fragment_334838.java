while(tc <= test_case){
    /*input what will do with Stack by String*/
    test = sc.next();

    /*call function by test String*/
    switch(test){
        case "push":
            push(array, sc.nextInt());
            break;
        case "pop":
            System.out.println(pop(array));
            break;
        case "size":
            System.out.println(size(array));
            break;
        case "empty":
            System.out.println(empty(array));
            break;
        case "top":
            System.out.println(top(array));
            break;
    }
}