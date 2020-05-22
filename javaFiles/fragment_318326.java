if(success) {
    System.out.println(response);
    if (arr != null) {
        for (int i=0;i<arr.length();i++){
            listdata.add(arr.get(i).toString());
            System.out.println(listdata.get(i));
        }
    }
    arrayAdapter.notifyDataSetChanged();
}