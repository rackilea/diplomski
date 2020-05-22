String input = "10 trillion 896 billion 45 million 56873";
        String pattern = "\\s\\d";     // this will match space and number thus will give you start of each number.
        ArrayList<Integer> inds = new ArrayList<Integer>();
        ArrayList<String> strs = new ArrayList<String>();
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        while (m.find()) {
            inds.add(m.start());          //start will return starting index.
        }

        //iterate over start indexes and each entry in inds array list will be the end index of substring. 
        //start index will be 0 and for subsequent iterations it will be end index + 1th position.
        int indx = 0;
        for(int i=0; i <= inds.size(); i++) {
            if(i < inds.size()) {
                strs.add(input.substring(indx, inds.get(i)));    
                indx = inds.get(i)+1;
            } else {
                strs.add(input.substring(indx, input.length()));
            }
        }

        for(int i =0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }