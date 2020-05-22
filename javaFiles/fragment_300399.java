{"success":"false", "message":"Credenciales de acceso inválidas. Inténtelo de nuevo.", "iduser":"0"}


class DataWrapper {
        public Data data;

        public static DataWrapper fromJson(String s) {
            return new Gson().fromJson(s, DataWrapper.class);
        }
        public String toString() {
            return new Gson().toJson(this);
        }
    }
    class Data {
        public boolean success;
        public String message;
        public int idUser;
    }