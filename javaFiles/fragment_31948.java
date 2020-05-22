import com.mycompany.mypackage.SomeBean;

import flexjson.JSONContext;
import flexjson.Path;
import flexjson.TypeContext;
import flexjson.transformer.AbstractTransformer;
import flexjson.transformer.TransformerWrapper;

    public class SOMapTransformer extends AbstractTransformer {

        public void transform(Object object) {
            JSONContext context = getContext();
            Path path = context.getPath();
            Map<String, List<SomeBean>> value = (Map<String, List<SomeBean>>) object;

            TypeContext typeContext = getContext().writeOpenObject();
            for (Object key : value.keySet()) {
                path.enqueue((String) key);

                //DPD 2013-11-04: This bloody line of code cost me 12 hours.  Comment it out!
//              if (context.isIncluded((String) key, value.get(key))) {

                    TransformerWrapper transformer = (TransformerWrapper)context.getTransformer(value.get(key));

                    if(!transformer.isInline()) {
                        if (!typeContext.isFirst()) getContext().writeComma();
                        typeContext.setFirst(false);
                        getContext().writeName(key.toString());
                    }

                    typeContext.setPropertyName(key.toString());

                    transformer.transform(value.get(key));

//              }

                path.pop();

            }
            getContext().writeCloseObject();
        }