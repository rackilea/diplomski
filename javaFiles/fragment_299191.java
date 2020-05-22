ClassPath.from(classloader).getTopLevelClasses("test.package").stream()
            .map(ClassPath.ClassInfo::load)
            .map(Class::getConstructors)
            .flatMap(Arrays::stream)
            .filter(constructor -> constructor.getParameterCount() == 0)
                    .findAny()
                    .orElseThrow(RuntimeException::new);