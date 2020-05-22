public static final String TYPE_KEY = "__type";
public static final String TYPE1_VAUE = "Section1:#com.test.example";
public static final String TYPE2_VAUE = "Section2:#com.test.example2";


public static final String INFO_KEY = "Info";
public static final String ALLERGY_KEY = "Allergy";

....

String infoString = null;
JSONArray allergyArray = null;

for (int i = 0; i < documentChild.length(); i++) {
    child = documentChild.getJSONObject(i);

    final String typeValue = child.getString(TYPE_KEY);

    if(TYPE1.equals(typeValue)) {
        infoString = child.getString(INFO_KEY);
    }else if(TYPE2.equals(typeValue)) {
        allergyArray = child.getJSONArray(ALLERGY_KEY);
    }
}

if(null != infoString) {
    // access the 'Info' value in 'infoString'
}

if(null != allergyArray) {
    // access the 'Allergy' array in 'allergyArray'
}

...