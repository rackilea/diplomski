package com.my.project.shared;

@PersistenceCapable(identityType=IdentityType.APPLICATION,detachable="true")
public class MyParent implements Serializable {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    private Long id;
    @NotPersistent //Note the NotPersistent annotation. GAE won't persist this value in big table
    private String description;

}