<c:forEach items="${transports}" var="transport">
    <div class="checkbox">
        <label>
            <input type="checkbox" value="${transport.id}" checked="${shop.hasTransport(transport)}"/> ${transport.name}
        </label>
    </div>
</c:forEach>