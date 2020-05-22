package p4;

import org.crygier.graphql.GraphQLExecutor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CompanyGraphQLComponent {

  @PersistenceContext(unitName = "company")
  private EntityManager entityManager;

  public GraphQLExecutor graphQLExecutor() {
    return new GraphQLExecutor(entityManager);
  }
}