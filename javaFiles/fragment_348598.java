<tr th:each="book, stat : ${books}" th:object="${book}">
                <!--        added for numbering purpose, variable stat is needed for iteration -->
                <td th:text="${stat.count}">1</td>
    ///////////////////////////////////////////////
                <td> 
                    <span th:each="author, iterator1: ${book.authors}" th:remove="tag">
                         <span th:utext="${iterator1.index+1+'. ' + author.forename+' <br/>'}" />
                    </span>
                 </td>
    ////////////////////////////////////
                <td th:text="*{title}"> Title</td>
                <td th:text="*{isbn}"> ISBN</td>
            </tr>