private void serializeQuotes(){
        FileOutputStream fos;
        try {
            fos = openFileOutput(Constants.FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(quotes); 
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void deserializeQuotes(){
        try{
            FileInputStream fis = openFileInput(Constants.FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            quotes = (ArrayList<Quote>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }