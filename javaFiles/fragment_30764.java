@Entity
@Table(name = "yourTable")
@NamedNativeQueries(value = {
        @NamedNativeQuery(name="nativeSelectName", 
                query = "select blah blah blah", resultClass = YourEntityClass.class)
})

@NamedQueries(value = {
        @NamedQuery(name = "hqlQuery",
            query = "from YourEntityClass where ...")