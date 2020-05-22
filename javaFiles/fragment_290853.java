@Getter
@RequiredArgsConstructor
enum YourEnum {
  COMMAND1(Command1::new),
  COMMAND2(Command2::new);

  private final Supplier<? extends Command> commandSupplier;

}