do{
    checkCat = false;
    for(int j = 0; j <= claimCount; j++){
        System.out.print("Please enter category ID: ");
        catId = input.next();
        if(catId.equals(claimCategory[j].GetClaimCategoryID())){
            checkCat = true;
            break;
        }
    } // end for
    if(!checkCat)
            System.out.println("Data not found");
}while(!checkCat);