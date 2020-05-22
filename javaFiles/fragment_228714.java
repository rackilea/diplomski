package com.pack;
import javax.jdo.annotations.*;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
 public class Entry {

@PrimaryKey
@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
private Key key;

@Persistent
private String poster;

@Persistent
private Text content;

public Entry() {

}

public Key getKey() {
    return key;
}

public Entry(Text content, String poster) {

    this.content = content;
    this.poster = poster;

}

public Text getContent() {

    return content;
}

public String getPoster() {
    return poster;
}

}