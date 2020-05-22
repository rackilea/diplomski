<form id="verteilung_form" class="form-horizontal" method="post" action="/verteilung"
            th:action="@{/konfiguration/verteilung}"
            th:object="${formBean}">

            <table  class="table-hover">
              <tr th:each="row: *{matrix}">
                <td th:each="value: ${row}">
                            <input type="checkbox" th:field="*{matrix[__${rowStat.index}__][__${valueStat.index}__]}"/> 
                    </td>
              </tr>
            </table>
            <div >
                <button th:text="#{button.save}" class="btn btn-default" type="submit" name="save">Speichern</button>
                <button th:text="#{button.reset}" name="reset" class="btn btn-default">Zurücksetzen</button>
            </div>
        </form>