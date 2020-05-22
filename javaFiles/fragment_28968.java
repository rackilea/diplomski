package org.yadavvi.tutorials.governor.data;

import com.google.gson.typeadapterfactory;
import com.ryanharter.auto.value.gson.gsontypeadapterfactory;

@GsonTypeAdapterFactory
public abstract class GovernorAdapterFactory implements TypeAdapterFactory {

    public static GovernorAdapterFactory create() {
        return new AutoValueGson_GovernorAdapterFactory();
    }

}