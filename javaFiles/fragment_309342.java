<form th:action="@{'/articles/' + ${article.id} + '/processTest'}" method="post">
    <table>
        <tr th:each="entry : ${wordsWithTranslation}">
            <td>
                <input type="text" th:value="${entry.key.value}" name="q[]" readonly="readonly"/>
            </td>
            <td> -----</td>
            <td><input type="text" name="a[]"/></td>
        </tr>
    </table>
    <input type="submit" value="Sprawdź"/>
</form>