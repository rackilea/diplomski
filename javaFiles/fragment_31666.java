@GenericGenerators({
    @GenericGenerator(
        name = "uuid2",
        strategy = "uuid2"
    )
})
package your.package;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;