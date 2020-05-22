<th:block th:each="store: ${stores}">
    <form class="store-form" th:action="@{/modify-store}">
        <input th:name="idStorePk" th:value="${store.idStorePk}"/>
        <input th:name="name" th:value="${store.name}"/>
        <input th:name="phoneNumber" th:value="${store.phoneNumber}"/>
        <button class="submit-button" type="submit">Modify</button>
    </form>
</th:block>