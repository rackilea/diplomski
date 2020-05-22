import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import de.hof.university.spj.model.Movie;

@RequestScoped
@ApplicationPath("/webservices")
@Path("/movies")
public class Test extends Application implements Serializable {
    private static final long serialVersionUID = 1L;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovieList() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SPJUnit");
        EntityManager em = factory.createEntityManager();

        TypedQuery<Movie> query = em.createQuery("Select m FROM Movie m WHERE m.movieID = 4204", Movie.class);

        return query.getResultList();
    }
}