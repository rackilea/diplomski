public class CustomSortHandlerMethodArgumentResolver extends 
        SortHandlerMethodArgumentResolver{



    @Override
    public Sort resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        Sort sort = super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);

        /*
            additional logic for filtering orders        
         */

        return sort != null && sort.iterator().hasNext() ? new Sort(sort.iterator().next()) : null;
    }
}