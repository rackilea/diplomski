package util;

    import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
    import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassAnnotationMatchProcessor;

    public class AnnotationScanTest {


        public static void main(String args[]) throws ClassNotFoundException {


            new FastClasspathScanner("com")
                    // Optional, in case you want to debug any issues with scanning.
                    // Add this right after the constructor to maximize the amount of log info.
                    .verbose()
                    // Add a MatchProcessor ("Mechanism 1")
                    .matchClassesWithAnnotation(Deprecated.class, new ClassAnnotationMatchProcessor() {
                        @Override
                        public void processMatch(Class<?> matchingClass) {
                            System.out.println("Matching annotation: " + matchingClass);
                        }
                    })
                    // Actually perform the scan (nothing will happen without this call)
                    .scan();
        }

    }