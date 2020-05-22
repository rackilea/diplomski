if (charCount.containsKey(s.charAt(i))){
            count=charCount.get(s.charAt(i));
            charCount.put(s.charAt(i), ++count); // changed to pre-increment
        } else {
            charCount.put(s.charAt(i), 1);
        }