@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
@EqualsAndHashCode(of = "id", callSuper = true)
public class MyClass extends MyAbstractClass {
  // everything else is unchanged