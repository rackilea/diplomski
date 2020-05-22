package snippet;

public class GeneralResponse {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "GeneralResponse [response=" + response + "]";
    }

}


package snippet;

public class ResultSets {

    private Products products;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ResultSets [products=" + products + "]";
    }

}

package snippet;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class Products {

    public List<Hits> hits;
    public String totalHits;

    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        // do something: put to a Map; log a warning, whatever
    }

    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }

    public String getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(String totalHits) {
        this.totalHits = totalHits;
    }

    @Override
    public String toString() {
        return "Products [hits=" + hits + ", totalHits=" + totalHits + "]";
    }

}


package snippet;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class Response {

    private ResultSets resultSets;

    public ResultSets getResultSets() {
        return resultSets;
    }

    public void setResultSets(ResultSets resultSets) {
        this.resultSets = resultSets;
    }

    @Override
    public String toString() {
        return "Response [resultSets=" + resultSets + "]";
    }

    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        // do something: put to a Map; log a warning, whatever
    }

}



package snippet;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class Hits {

    public String number;
    public String title;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        // do something: put to a Map; log a warning, whatever
    }

    @Override
    public String toString() {
        return "Hits [number=" + number + ", title=" + title + "]";
    }

}