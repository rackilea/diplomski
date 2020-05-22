else if(source == sortMI){
        String[] list = nameList.getItems();
        String[] nums = numberList.getItems();
        Arrays.sort(list);
        Arrays.sort(nums);
        for(int i = 0; i<list.length;i++){
            nameList.replaceItem(list[i],i);
            numberList.replaceItem(nums[i],i);
        }
        nameList.revalidate();
        numberList.revalidate();
    }