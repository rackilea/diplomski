public class PathConverter implements AttributeConverter<Path, String> {

    @Override
    public String convertToDatabaseColumn(Path path) {
        return path.toString();
    }

    @Override
    public Path convertToEntityAttribute(String path) {
        return Paths.get(path);
    }
}

@Column(name = "selected_paths")
@ElementCollection(targetClass = Path.class)
@Convert(converter = PathConverter.class)
private Set<Path> selectedPaths;

@Column(name = "unselected_paths")
@ElementCollection(targetClass = Path.class)
@Convert(converter = PathConverter.class)
private Set<Path> unSelectedPaths;