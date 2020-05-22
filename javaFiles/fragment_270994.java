package stackoverflow.questions.q18943680;

import com.google.gson.Gson;

public class Q18943680 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String json = "{"+
          "  \"owner\": {                                                                     "+
          "  \"username\": \"bobby\",                                                         "+
          "  \"password\": \"$2a$10$KTouvpAZwyUiCOsvMej.i.zNcGVt94d.n64MHWyxX35ZR03tWCIui\",  "+
          "  \"email\": \"bobby@email.com\",                                                  "+
          "  \"name\": \"Bobby P\",                                                           "+
          "  \"_id\": \"51a59d917997582c3a000003\",                                           "+
          "  \"__v\": 0,                                                                      "+
          "                                                                                   "+
          "  \"phones\": [                                                                    "+
          "    \"11118012888\",                                                               "+
          "    \"12341234\",                                                                  "+
          "    \"987655775\"                                                                  "+
          "                                                                                   "+
          "  ],                                                                               "+
          "  \"altemails\": [                                                                 "+
          "    \"a@a.com\",                                                                   "+
          "    \"b@b.com\",                                                                   "+
          "    \"c@c.com\"                                                                    "+
          "  ]                                                                                "+
          "                                                                                   "+
          "},                                                                                 "+
          "                                                                                   "+
          "\"facilities\": [                                                                  "+
          "  {                                                                                "+
          "    \"url\": \"/v1/facilities/51a5a6237997582c3a000006\"                           "+
          "  },                                                                               "+
          "  {                                                                                "+
          "    \"url\": \"/v1/facilities/51a5a6237997582c3a000007\"                           "+
          "  },                                                                               "+
          "  {                                                                                "+
          "    \"url\": \"/v1/facilities/51a5b533ebcefa893d000003\"                           "+
          "  },                                                                               "+
          "  {                                                                                "+
          "    \"url\": \"/v1/facilities/51b0238edadae8024f000003\"                           "+
          "  }                                                                                "+
          "]}                                                                                  ";


        Gson g = new Gson();
        TestBean tb = g.fromJson(json, TestBean.class);

        System.out.println("This is the result: "+tb.facilities);

    }

}