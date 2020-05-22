class Param extends HashMap<String, String>{


    @Override
    public String get(Object key) {
        if(!super.containsKey(key)){
            super.put(key.toString(), "");
        }
        return super.getOrDefault(key, "t");
    }

    @Override
    public boolean containsKey(Object arg0) {
        return true;
    }   
}

public class UriComponenet {

    public static void main(String[] args) {

        Param params = new Param();
        params.put("customer-id", "1");
        String specialURL="https://someurl/customers?customer-id={customer-id}&type={type}&something={something}";
        UriComponents customerUrl = UriComponentsBuilder
              .fromHttpUrl(specialURL)
              .buildAndExpand(params).encode();

        System.out.println(customerUrl);        
    }
}