import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
import org.junit.Assert;

Assert.assertThat(people, (Every.everyItem(HasPropertyWithValue.hasProperty("gender", Is.is("male")))));