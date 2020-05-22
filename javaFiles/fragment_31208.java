package org.example;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;

@Entity
@NamedQuery(name = "findCustomersByCity",
            query = "SELECT c " +
                    "FROM Customer c " +
                    "WHERE c.address.city = :city")
@XmlRootElement
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToOne(mappedBy="customer", cascade={CascadeType.ALL})
    private Address address;

    @OneToMany(mappedBy="customer", cascade={CascadeType.ALL})
    private Set<PhoneNumber> phoneNumbers;

}