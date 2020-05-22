@Mapper
public interface CMapper {

    C BtoC(B b);

    default Long myFieldConverter(A myField) {
        return myField.getId();
    }
}