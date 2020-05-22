package com.my.project.server;

@PersistenceCapable(identityType=IdentityType.APPLICATION,detachable="true")
public class MyChild implements Serializable{//Not really required to implement Serializable

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id;
    @Persistent
    private Long parentID;//Reference to the MyParent
    @Persistent
    private Text description;//The actual value of the description variable.
}