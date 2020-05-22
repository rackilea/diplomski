public <thing> void GetInstanceService(String method, TypeToken<thing> token) {
     List<thing> response = new ArrayList<thing>();

     Type rType2 = new TypeToken<List<thing>>() {}
         .where(new TypeParameter<thing>() {}, token); // where() binds "thing" to token
         .getType();

     type2 = uJSON.fromJson(new String(entity), rType2);
}

comm.GetInstanceService("listTestType", new TypeToken<msgType>() {});