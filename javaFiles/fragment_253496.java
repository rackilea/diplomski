create or replace function get_success_message
(
    p_statement clob,
    p_number_of_rows number
) return varchar2 is
    v_success_message varchar2(4000);
    v_ignore          varchar2(4000);
begin
    --Get the feedback message.
    statement_feedback.get_feedback_message(
        p_tokens                  => plsql_lexer.lex(p_statement),
        p_rowcount                => p_number_of_rows,
        p_success_message         => v_success_message,
        p_compile_warning_message => v_ignore
    );

    return v_success_message;
end;
/