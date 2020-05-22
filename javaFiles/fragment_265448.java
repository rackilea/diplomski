671    private boolean isHttpMethodValid(HttpServletRequest request) {
672        boolean result = false;
673        if (allowAllMethods) {
674            result = true;
675        } else {
676            String requestMethodString = request.getMethod();
677            HttpMethod requestMethod = null;
678            boolean isKnownHttpMethod;
679            try {
680                requestMethod = HttpMethod.valueOf(requestMethodString);
681                isKnownHttpMethod = true;
682            } catch (IllegalArgumentException e) {
683                isKnownHttpMethod = false;
684            }
685            if (isKnownHttpMethod) {
686                result = allowedKnownHttpMethods.contains(requestMethod);
687            } else {
688                result = allowedUnknownHttpMethods.contains(requestMethodString);
689            }
690            
691        }
692
693        return result;
694    }