// context has 'default' visibility
// so we need to stay in the same package 
// to be able to access it
package io.swagger.jaxrs.listing;

import javax.servlet.ServletContext;

public class ApiListingSubResource extends ApiListingResource {
    public ApiListingSubResource(ServletContext sc) { this.context = sc; }
}