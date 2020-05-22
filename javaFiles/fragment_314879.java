@FilterDef(name="groupFilter", parameters={@ParamDef( name="group", type="string" )})
@Filters(
  { @Filter(name="groupFilter", condition="group = :group") }
)
public class ... {
}