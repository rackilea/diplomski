package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
class Body {

    @XmlElement(name = "CONSUMER_PROFILE2")
    private ConsumerProfile profile;

    public Body(){}

    public ConsumerProfile getProfile() {
        return profile;
    }

    public void setProfile(ConsumerProfile profile) {
        this.profile = profile;
    }
}