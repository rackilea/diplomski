<#assign client_sequence=['a', 'b','c']>
{
    clients: ${client_sequence?join(", ")}
    usecase_key: usecase_value,
    other_key: other_value
}