public void agregarUsuario(String nombre, String apellido, String direccion, String telefono, String correo, String username, String password) //this function add a new user object to my array in the json
{
    try {
        JSONObject usuarios = getJSONObjectFromFile("/usuarios.json"); //Json object "usuarios"/"users" is my main json obj file
        JSONArray listaUsuario = usuarios.getJSONArray("Usuarios");     //I've start my array "Usuarios" (who is in my .json)
        JSONObject newObject = new JSONObject();                        //I created a new JSONObjectVariable, with the attributes i want in it
        newObject.put("nombre", nombre);
        newObject.put("apellido", apellido);
        newObject.put("direccion", direccion);
        newObject.put("telefono", telefono);
        newObject.put("correo", correo);
        newObject.put("username",username);
        newObject.put("password", password);
                                                                        //at this point my new object has all the attributes i want to put in my array
        listaUsuario.put(newObject);                                    //so here i tried to put in my array my new Json object
        usuarios.put("Usuarios",listaUsuario);                          //this line, is one of my attempts to figure out how to put the function working
                                                                        //it wasn't in the first time, but how listaUsuario.put(newObject) dint make any change in my .json...
                                                                        //with or without it doesn't do anything 

        ObjectOutputStream outputStream = null;

           outputStream = new ObjectOutputStream(new FileOutputStream("/usuarios.json"));
           System.out.println("Start Writing in to file ");
            outputStream.writeObject(usuarios.toString());
            outputStream.flush();
            outputStream.close();

    }catch(JSONException e) {
        e.printStackTrace();
    }
    catch (Exception e){
        System.err.println("Error writting json: " + e);
    }
 }