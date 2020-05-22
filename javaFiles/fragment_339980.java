package p4.rest.controllers;

import core_services.persistence.CompanyContextHolder;
import core_services.records.system.Company;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p4.CompanyGraphQLComponent;
import p4.records.GraphQLQuery;

@RestController
public class GraphQLController {
  @Autowired
  private CompanyGraphQLComponent companyGraphQLComponent;

  @RequestMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ExecutionResult postJson(@RequestBody GraphQLQuery graphQLQuery) {
    return companyGraphQLComponent.graphQLExecutor().execute(graphQLQuery.getQuery(), graphQLQuery.getVariables());
  }
}