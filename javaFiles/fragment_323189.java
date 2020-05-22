public int getFirstedit() { 
    if(getPlatformList().isEmpty()){ // change here
        return 1; 
        // Display add form
    }
    else  {
        return 0;
        // Display update form
    }
}