for(int i = 0; i < booksArray.length(); i++){

        JSONObject currentBook = booksArray.getJSONObject(i);
        JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");
        JSONArray authorsArray = volumeInfo.getJSONArray("authors");
        String authors = "";
        for(int i=0; i<authorsArray.length();i++) {
            authors = authors +","+authorsArray.getString(i);
        }

        //set the other strings as is

        Books book = new Books(title, authors, publisher, publishdDate, language, pageCount, printType, maturityRating);
        books.add(book);
    }