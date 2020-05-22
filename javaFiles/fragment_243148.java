for (int i = 0; i < nameCollection.length; i++){
        if(i < meaningCollection.length) {
            names.add(new Name(nameCollection[i] + "  ",
                meaningCollection[i] + "  "));
        } else {
            names.add(new Name(nameCollection[i] + "  ",
                "no meaning"));
            // replace "no meaning" with whatever default value you'd like
        }
    }
}