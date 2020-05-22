try {
            bJoin.<String>get(sort.split(":")[0]).as(String.class);

            //Use bJoin table to order
        }catch(Exception e) {
            //Use iRoot table to order
        }