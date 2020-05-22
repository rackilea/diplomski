if(curr == stop) {
        String[] dest = new String[str.length];
        System.arraycopy( str, 0, dest, 0, str.length );
        result.add(dest);

        System.out.println(Arrays.toString(str));
        return result;
    }