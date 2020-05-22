import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.BeanUtils;

import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

@Provider
public final class ParameterBeanProvider implements InjectableProvider<QueryParam, Parameter> {

    @Context
    private final HttpContext hc;

    public ParameterBeanProvider(@Context HttpContext hc) {
        this.hc = hc;
    }

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable<ParameterBean> getInjectable(ComponentContext ic, final QueryParam a, final Parameter c) {

        if (ParameterBean.class != c.getParameterClass()) {
            return null;
        }

        return new Injectable<ParameterBean>() {

            public ParameterBean getValue() {
                ParameterBean parameterBean = new ParameterBean();
                MultivaluedMap<String, String> params = hc.getUriInfo().getQueryParameters();
                // Populate the parameter bean properties
                for (Entry<String, List<String>> param : params.entrySet()) {
                    String key = param.getKey();
                    Object value = param.getValue().iterator().next();

                    // set the property
                    BeanUtils.setProperty(parameterBean, key, value);
                }
                return parameterBean;
            }
        };
    }
}